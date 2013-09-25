package parsecode;

/*
 * "TIRE_PRESSURE:tp,
GEO_BOUNDARY:gb,
IGN_STATE:ig,
IGN_CYCLES:ic,
ODO_MONITOR:od,
TIMESTAMP:ts,
PERIODIC_DISTANCE:pd,
DTC:dt,
OIL_LIFE_MONITOR:ol,
TIRE_PRESSURE_STATUS_MONITOR:ps,
FUEL_LEVEL_MONITOR:fl
"
"And:A, Or:O, Not:N"

"A[tp,ig]"
"A[O[fl,pd],A[ic,N[od]]]"

[ [fl or pd] and [not ic] ]

"And[TIRE_PRESSURE, IGN_STATE]"
[TIRE_PRESSURE and IGN_STATE]
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ParseString {

  public static String translateFormat(String inputStr) {

    String translatedCode = translateCode(inputStr);

    Node head = parseTranslatedCode(translatedCode);

    return head.toString();
  }


  private static Node parseTranslatedCode(String translatedCode) {

    System.out.println("translatedCode: " + translatedCode);

    String[] elements = translatedCode.split("[,\\[\\]]");

    LinkedList<String> elementsList = new LinkedList<String>();

    for (int i = 0 ; i < elements.length ; i++) {
      if (elements[i].length() != 0) {
         System.out.println(elements[i]);
        elementsList.add(elements[i]);
      }
    }

    // System.out.println(elementsList);
    Map<String, String> operandMap = getOperandMap();
    Map<String, String> operatorMap = getOperatorMap();

    Node head = parseTree(elementsList, operandMap, operatorMap);

    return head;
  }


  private static Node parseTree(LinkedList<String> elementsList, Map<String, String> operandMap, Map<String, String> operatorMap) {

    if (elementsList.size() == 0) {
      return null;
    }

    String first = elementsList.removeFirst();

    Node head = null;

    // if first element is an operand element
    if (operandMap.keySet().contains(first)) {

      head = new OperandNode(first);

      // if first element is an operator element
    } else if (operatorMap.keySet().contains(first)) {

      head = new OperatorNode(first);

      while (head.needMoreChildren()) {
        
        head.addChild(parseTree(elementsList, operandMap, operatorMap));
      }
    }

    return head;
  }


  private static String translateCode(String inputStr) {

    System.out.println("Input: " + inputStr);

    Map<String, String> operandMap = getOperandMap();
    Map<String, String> operatorMap = getOperatorMap();

    Map<String, String> reversedOperandMap = new HashMap<String, String>();
    Map<String, String> reversedOperatorMap = new HashMap<String, String>();

    // Only if the values in operandMap is UNIQUE!
    for (String key : operandMap.keySet()) {
      reversedOperandMap.put(operandMap.get(key), key);
    }

    // Only if the values in operatorMap is UNIQUE!
    for (String key : operatorMap.keySet()) {
      reversedOperatorMap.put(operatorMap.get(key), key);
    }


    String[] elements = inputStr.split("(?<=[,\\[\\]])|(?=[,\\[\\]])");

    StringBuffer sb = new StringBuffer();

    for (int i = 0 ; i < elements.length ; i++) {

      String element = elements[i];

      if (reversedOperandMap.containsKey(element)) {
        sb.append(reversedOperandMap.get(element));
      } else if (reversedOperatorMap.containsKey(element)) {
        sb.append(reversedOperatorMap.get(element));
      } else if (element.equals("[") || element.equals("]") || element.equals(",")) {
        sb.append(element);
      } else {
        System.out.println("Error, invalid input element -->" + element + "#");
      }
    }


    return sb.toString();
  }


  private static Map<String, String> getOperatorMap() {

    Map<String, String> map = new HashMap<String, String>();

    map.put("AND", "A");
    map.put("OR", "O");
    map.put("NOT", "N");

    return map;
  }


  private static Map<String, String> getOperandMap() {

    Map<String, String> map = new HashMap<String, String>();

    map.put("TIRE_PRESSURE", "tp");
    map.put("GEO_BOUNDARY", "gb");
    map.put("IGN_STATE", "ig");
    map.put("IGN_CYCLES", "ic");
    map.put("ODO_MONITOR", "od");
    map.put("TIMESTAMP", "ts");
    map.put("PERIODIC_DISTANCE", "pd");
    map.put("DTC", "dt");
    map.put("OIL_LIFE_MONITOR", "ol");
    map.put("TIRE_PRESSURE_STATUS_MONITOR", "ps");
    map.put("FUEL_LEVEL_MONITOR", "fl");

    return map;
  }


  public static void main(String[] args) {

    String str = translateFormat("A[O[fl,N[pd],dt],A[ic,N[od]],N[ol]]");
    System.out.println(str);
  }
}


class Node {

  protected String value;
  protected List<Node> children;


  public Node(String value) {

    this.value = value;
    this.children = new ArrayList<Node>();
  }


  public boolean needMoreChildren() {

    return false;
  }


  public void addChild(Node child) {

    children.add(child);
  }


  public String getValue() {

    return value;
  }


  public String toString() {

    return value;
  }


}


class OperandNode extends Node {

  public OperandNode(String value) {

    super(value);
  }

}


class OperatorNode extends Node {

  private int numOfChildren = 0;


  public OperatorNode(String value) {

    super(value);

    if (value.equalsIgnoreCase("AND") || value.equalsIgnoreCase("OR")) {
      numOfChildren = 2;
    } else if (value.equalsIgnoreCase("NOT")) {
      numOfChildren = 1;
    } else {
      System.out.println("Error # 1");
    }
  }


  public void addChild(Node child) {

    super.addChild(child);
  }


  public boolean needMoreChildren() {

    return children.size() < numOfChildren;
  }


  public String toString() {

    if (value == null) {
      return " null ";
    }

    StringBuffer sb = new StringBuffer();

    sb.append("[");

    if (value.equalsIgnoreCase("AND") || value.equalsIgnoreCase("OR")) {

      sb.append(children.get(0));
      sb.append(" ");
      sb.append(value);
      sb.append(" ");
      sb.append(children.get(1));

    } else if (value.equalsIgnoreCase("NOT")) {

      sb.append(value);
      sb.append(" ");
      sb.append(children.get(0));

    } else {
      System.out.println("Error # 2");
    }

    sb.append("]");

    return sb.toString();
  }
}