package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import config.Setting;


public class Logger {
	// file format for log name
		static ZonedDateTime date = ZonedDateTime.now();
		static private BufferedWriter bfWriter = null;
		static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
		static String fileNameFormat = date.format(formatter);

		// create log file
		public static void createLogFile() {
			try {
				File dir = new File(Setting.logPath);
				if (!dir.exists()) {
					dir.mkdir();
				}
				File logFile = new File(dir + "/" + fileNameFormat + ".log");
				FileWriter fileWriter = new FileWriter(logFile.getAbsolutePath());
				bfWriter = new BufferedWriter(fileWriter);
			} catch (Exception e) {

			}
		}

		// write message within log
		public void write(String message) {
			try {
				bfWriter.write("[" + fileNameFormat + "]" + message);
				bfWriter.newLine();
				bfWriter.flush();
				;
			} catch (Exception e) {

			}
		}
}
