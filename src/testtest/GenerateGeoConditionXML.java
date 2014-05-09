package testtest;

import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.onstar.vcs.vtm.jaxb.types.Action;
import com.onstar.vcs.vtm.jaxb.types.CallAction;
import com.onstar.vcs.vtm.jaxb.types.ConditionEvaluationModeType;
import com.onstar.vcs.vtm.jaxb.types.DataMonitorCondition;
import com.onstar.vcs.vtm.jaxb.types.Execute;
import com.onstar.vcs.vtm.jaxb.types.GeoBoundaryCondition;
import com.onstar.vcs.vtm.jaxb.types.ObjectFactory;
import com.onstar.vcs.vtm.jaxb.types.SetVehicleTaskRequestData;
import com.onstar.vcs.vtm.jaxb.types.SubTask;
import com.onstar.vcs.vtm.jaxb.types.TaskData;
import com.onstar.vcs.vtm.jaxb.types.TriggerLocation;

public class GenerateGeoConditionXML {

  public static void main(String[] args) {

    createConditionXML();
  }


  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static void createConditionXML() {

    try {
      JAXBContext context = JAXBContext.newInstance(DataMonitorCondition.class);
      com.onstar.vcs.vtm.jaxb.types.ObjectFactory factory = new com.onstar.vcs.vtm.jaxb.types.ObjectFactory();
      Marshaller m = context.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      // //////////////////////////////////////////////////////////////////////////////////////////////////

      GeoBoundaryCondition geoBoundaryCondition = new GeoBoundaryCondition();

      geoBoundaryCondition.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

      geoBoundaryCondition.setLatitude(11.0);

      geoBoundaryCondition.setLongitude(33.21);

      geoBoundaryCondition.setRadius(new BigDecimal(43.1));

      geoBoundaryCondition.setTriggerLocation(TriggerLocation.INSIDE_CIRCLE);

      JAXBElement<GeoBoundaryCondition> geoBoundaryCondition1 = factory.createGeoBoundaryCondition(geoBoundaryCondition);

      System.out.println("****************************** Start create XML ******************************");
      m.marshal(geoBoundaryCondition1, System.out);
      System.out.println("****************************** End create XML ********************************\n");


      SetVehicleTaskRequestData setVehicleTaskRequestData1 = new SetVehicleTaskRequestData();

      TaskData taskDataArray[] = new TaskData[1];
      taskDataArray[0] = new TaskData();
      SubTask subTaskArray[] = new SubTask[1];
      subTaskArray[0] = new SubTask();
      taskDataArray[0].setSubTask(subTaskArray);

      subTaskArray[0].setCondition(geoBoundaryCondition1);

      JAXBElement actionJaxbelementArr[] = new JAXBElement[1];

      Action action = new CallAction();

      JAXBElement<? extends Action> actionJAXB = factory.createAction(action);

      actionJaxbelementArr[0] = actionJAXB;

      Execute execute = new Execute();

      execute.setAction(actionJaxbelementArr);

      subTaskArray[0].setExecute(execute);

      setVehicleTaskRequestData1.setTaskData(taskDataArray);

      ObjectFactory objectFactory = new ObjectFactory();

      JAXBElement<SetVehicleTaskRequestData> setVehicleTaskRequestData = objectFactory.createSetVehicleTaskRequestData(setVehicleTaskRequestData1);

      m.marshal(setVehicleTaskRequestData, System.out);

    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
