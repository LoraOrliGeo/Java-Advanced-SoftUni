package a011_StacksAndQueues_Ex_16May2019;

//import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
//import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_Robotics {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		List<String> robots = Arrays.stream(sc.nextLine().split(";")).collect(Collectors.toList());
		
		String[] names = new String[robots.size()];
		int[] proccessTime = new int[robots.size()];
		int[] workTime = new int[robots.size()];
		
		for (int i = 0; i < robots.size(); i++) {
			String[] tokens = robots.get(i).split("\\-");
			String name = tokens[0];
			int time = Integer.parseInt(tokens[1]);
			names[i] = name;
			proccessTime[i] = time;
		}
		
		String startTime = sc.nextLine();
		
		ArrayDeque<String> products = new ArrayDeque<>();
		
		String inputProduct = "";
		
		while (!"End".equals(inputProduct = sc.nextLine())) {
			products.offer(inputProduct);
		}
		
		// LocalTime time = LocalTime.of(hours, minutes, seconds);
		
		String[] timeData = startTime.split(":");
		int hours = Integer.parseInt(timeData[0]);
		int minutes = Integer.parseInt(timeData[1]);
		int seconds = Integer.parseInt(timeData[2]);
		
		int beginTime = hours * 3600 + minutes * 60 + seconds;
		
		while (!products.isEmpty()) {
			//time = time.plusSeconds(1);
			beginTime++;
			
			String product = products.poll();
			boolean isAssign = false;
			
			for (int i = 0; i < names.length; i++) {
				if (workTime[i] == 0 && !isAssign) {
					workTime[i] = proccessTime[i];
					
					isAssign = true;
					System.out.println(printRobotData(names[i], product, beginTime));
				}
				
				if (workTime[i] > 0) {
					workTime[i]--;
				}
			}
			
			if (!isAssign) {
				products.offer(product);
			}
		}
	}

	public static String printRobotData(String robot, String product, int beginTime) {
		// LocalTime time as a parameter
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		long s = beginTime % 60;
        long m = (beginTime / 60) % 60;
        long h = (beginTime / (60 * 60)) % 24;
 
        String time = String.format("%02d:%02d:%02d", h, m, s);
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//	    calendar.set(Calendar.MINUTE, 0);
//	    calendar.set(Calendar.MILLISECOND, 0);      
//	    calendar.set(Calendar.SECOND, beginTime);
//	    String time = new SimpleDateFormat("HH:mm:ss").format(calendar.getTime());
	    
        return String.format("%s - %s [%s]", robot, product, time);
	}
}
