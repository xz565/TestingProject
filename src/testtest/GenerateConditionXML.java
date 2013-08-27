package testtest;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.onstar.vcs.vtm.jaxb.types.AlwaysCondition;
import com.onstar.vcs.vtm.jaxb.types.BufferFullCondition;
import com.onstar.vcs.vtm.jaxb.types.ConditionEvaluationModeType;
import com.onstar.vcs.vtm.jaxb.types.DataMonitorCondition;
import com.onstar.vcs.vtm.jaxb.types.DaysAtTimeCondition;
import com.onstar.vcs.vtm.jaxb.types.DelayCondition;
import com.onstar.vcs.vtm.jaxb.types.GeoBoundaryCondition;
import com.onstar.vcs.vtm.jaxb.types.IgnitionCycleCondition;
import com.onstar.vcs.vtm.jaxb.types.IgnitionStateCondition;
import com.onstar.vcs.vtm.jaxb.types.IgnitionStateValueType;
import com.onstar.vcs.vtm.jaxb.types.PacketConnectionType;
import com.onstar.vcs.vtm.jaxb.types.PacketDataAvailableCondition;
import com.onstar.vcs.vtm.jaxb.types.PeriodicDistanceCondition;
import com.onstar.vcs.vtm.jaxb.types.PeriodicTimerCondition;
import com.onstar.vcs.vtm.jaxb.types.ResultType;
import com.onstar.vcs.vtm.jaxb.types.RoamingStatusType;
import com.onstar.vcs.vtm.jaxb.types.TimeUnit;
import com.onstar.vcs.vtm.jaxb.types.TimestampCondition;
import com.onstar.vcs.vtm.jaxb.types.TriggerLocation;
import com.onstar.vcs.vtm.jaxb.types.VehicleStateValueType;
import com.onstar.vcs.vtm.jaxb.types.WeekDays;
import com.onstar.vcs.vtm.jaxb.types.WeekDays.WeekDay;
import com.onstar.vcs.vtm.jaxb.types.WeeklyRangeCondition;

public class GenerateConditionXML {

	public static void main(String[] args) {

		createConditionXML();
	}

	private static void createConditionXML() {
		try {
			JAXBContext context = JAXBContext
					.newInstance(DataMonitorCondition.class);
			com.onstar.vcs.vtm.jaxb.types.ObjectFactory factory = new com.onstar.vcs.vtm.jaxb.types.ObjectFactory();
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// ///////////////////////////////////////////////////////////////////////////////////////////////////
			DataMonitorCondition dataMonitorCondition = new DataMonitorCondition();

			dataMonitorCondition.setElementName("ODO");

			dataMonitorCondition.setOnChangeOnly(true);

			ResultType[] results = new ResultType[1];
			results[0] = new ResultType();
			results[0].setName("resultName1");
			dataMonitorCondition.setResult(results);

			dataMonitorCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			JAXBElement<DataMonitorCondition> dataMonitorCondition1 = factory
					.createDataMonitorCondition(dataMonitorCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(dataMonitorCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////
			AlwaysCondition alwaysCondition = new AlwaysCondition();

			alwaysCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			JAXBElement<AlwaysCondition> alwaysCondition1 = factory
					.createAlwaysCondition(alwaysCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(alwaysCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////
			BufferFullCondition bufferFullCondition = new BufferFullCondition();

			bufferFullCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			bufferFullCondition.setTaskId(6);

			bufferFullCondition.setPercentFull(new BigDecimal(2.0));

			JAXBElement<BufferFullCondition> bufferFullCondition1 = factory
					.createBufferFullCondition(bufferFullCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(bufferFullCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////
			DaysAtTimeCondition daysAtTimeCondition = new DaysAtTimeCondition();

			daysAtTimeCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			daysAtTimeCondition.setDays(3);

			daysAtTimeCondition.setHour(4);

			daysAtTimeCondition.setMinute(5);

			daysAtTimeCondition
					.setEvaluateDuringVehicleState(VehicleStateValueType.ALWAYS);

			JAXBElement<DaysAtTimeCondition> daysAtTimeCondition1 = factory
					.createDaysAtTimeCondition(daysAtTimeCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(daysAtTimeCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////
			DelayCondition delayCondition = new DelayCondition();

			delayCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			delayCondition.setDelayTime(3);

			delayCondition
					.setEvaluateDuringIgnitionState(IgnitionStateValueType.ALWAYS);

			JAXBElement<DelayCondition> delayCondition1 = factory
					.createDelayCondition(delayCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(delayCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////

			GeoBoundaryCondition geoBoundaryCondition = new GeoBoundaryCondition();

			geoBoundaryCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			geoBoundaryCondition.setLatitude(11.0);

			geoBoundaryCondition.setLongitude(33.21);

			geoBoundaryCondition.setRadius(new BigDecimal(43.1));

			geoBoundaryCondition
					.setTriggerLocation(TriggerLocation.INSIDE_CIRCLE);

			JAXBElement<GeoBoundaryCondition> geoBoundaryCondition1 = factory
					.createGeoBoundaryCondition(geoBoundaryCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(geoBoundaryCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////
			IgnitionCycleCondition ignitionCycleCondition = new IgnitionCycleCondition();

			ignitionCycleCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			ignitionCycleCondition
					.setCountDuring(IgnitionStateValueType.ALWAYS);

			ignitionCycleCondition.setNumberOfCycles(5);

			JAXBElement<IgnitionCycleCondition> ignitionCycleCondition1 = factory
					.createIgnitionCycleCondition(ignitionCycleCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(ignitionCycleCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////
			IgnitionStateCondition ignitionStateCondition = new IgnitionStateCondition();

			ignitionStateCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			ignitionStateCondition
					.setEvaluateDuringIgnitionState(IgnitionStateValueType.ALWAYS);

			JAXBElement<IgnitionStateCondition> ignitionStateCondition1 = factory
					.createIgnitionStateCondition(ignitionStateCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(ignitionStateCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////

			PacketDataAvailableCondition packetDataAvailableCondition = new PacketDataAvailableCondition();

			packetDataAvailableCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			packetDataAvailableCondition
					.setConnectionType(PacketConnectionType.ANY);

			packetDataAvailableCondition
					.setRoamingStatus(RoamingStatusType.ANY);

			JAXBElement<PacketDataAvailableCondition> packetDataAvailableCondition1 = factory
					.createPacketDataAvailableCondition(packetDataAvailableCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(packetDataAvailableCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////

			PeriodicDistanceCondition periodicDistanceCondition = new PeriodicDistanceCondition();

			periodicDistanceCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			periodicDistanceCondition.setDistance(12);

			JAXBElement<PeriodicDistanceCondition> periodicDistanceCondition1 = factory
					.createPeriodicDistanceCondition(periodicDistanceCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(periodicDistanceCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////

			PeriodicTimerCondition periodicTimerCondition = new PeriodicTimerCondition();

			periodicTimerCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			periodicTimerCondition
					.setEvaluateDuringIgnitionState(IgnitionStateValueType.ALWAYS);

			periodicTimerCondition.setPeriod(1);

			periodicTimerCondition.setUnit(TimeUnit.HOUR);

			JAXBElement<PeriodicTimerCondition> periodicTimerCondition1 = factory
					.createPeriodicTimerCondition(periodicTimerCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(periodicTimerCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////

			TimestampCondition timestampCondition = new TimestampCondition();

			timestampCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			timestampCondition
					.setEvaluateDuringVehicleState(VehicleStateValueType.ALWAYS);

			timestampCondition.setTimestampValue(Calendar.getInstance());

			JAXBElement<TimestampCondition> timestampCondition1 = factory
					.createTimestampCondition(timestampCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(timestampCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

			// //////////////////////////////////////////////////////////////////////////////////////////////////

			WeeklyRangeCondition weeklyRangeCondition = new WeeklyRangeCondition();

			weeklyRangeCondition
					.setConditionEvaluationMode(ConditionEvaluationModeType.DEFAULT);

			weeklyRangeCondition.setEndHour(2);

			weeklyRangeCondition.setEndMinute(20);

			weeklyRangeCondition.setStartHour(1);

			weeklyRangeCondition.setStartMinute(10);

			WeekDays weekDays = new WeekDays();

			WeekDay[] weekDayArr = new WeekDay[3];
			weekDayArr[0] = new WeekDay();
			weekDayArr[0].setDay("Sunday");

			weekDays.setWeekDay(weekDayArr);
			weeklyRangeCondition.setWeekDays(weekDays);

			JAXBElement<WeeklyRangeCondition> weeklyRangeCondition1 = factory
					.createWeeklyRangeCondition(weeklyRangeCondition);

			System.out
					.println("****************************** Start create XML ******************************");
			m.marshal(weeklyRangeCondition1, System.out);
			System.out
					.println("****************************** End create XML ********************************\n");

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}