package lcoj.common;


public class RandomListNode {

  public int label;
  public RandomListNode next, random;


  public RandomListNode(int x) {

    this.label = x;
  }


  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("RandomListNode [label=");
    builder.append(label);
    builder.append(", next=");
    builder.append(next);
    builder.append(", random=");
    builder.append(random);
    builder.append("]");
    return builder.toString();
  }


}
