import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;

public class GetMp3FileDuration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "E:\\Story\\金猫传奇\\goldcat_26.mp3";
		
		File file = new File(path);
		
		int len = getMp3TrackLength(file);
		System.out.println(len);
		long duration = len * 1000;
		System.out.println(mediaTimeFormat(duration));
		try {
			getAudioPlayTime(path);
		} catch (BitstreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 读取音频总时长
	public static void getAudioPlayTime(String mp3) throws IOException,
			BitstreamException {
		File file = new File(mp3);
		FileInputStream fis = new FileInputStream(file);
		int b = fis.available();
		Bitstream bt = new Bitstream(fis);
		Header h = bt.readFrame();
		int time = (int) h.total_ms(b);
		System.out.println(time);
		System.out.println(mediaTimeFormat(time));
	}

	/** 
     * 格式化时间，将毫秒转换为分:秒格式 
     * @param time audio/video time like 12323312
     * @return the format time string like 00:12:23
     */  
	public static String mediaTimeFormat(long duration) {
		long hour = duration / (60 * 60 * 1000);
		String min = duration % (60 * 60 * 1000) / (60 * 1000) + "";
		String sec = duration % (60 * 60 * 1000) % (60 * 1000) + "";

		if (min.length() < 2) {
			min = "0" + duration / (1000 * 60) + "";
		}

		if (sec.length() == 4) {
			sec = "0" + sec;
		} else if (sec.length() == 3) {
			sec = "00" + sec;
		} else if (sec.length() == 2) {
			sec = "000" + sec;
		} else if (sec.length() == 1) {
			sec = "0000" + sec;
		}

		if (hour == 0) {
			return min + ":" + sec.trim().substring(0, 2);
		} else {
			String hours = "";
			if (hour < 10) {
				hours = "0" + hour;
			} else {
				hours = hours + "";
			}
			return hours + ":" + min + ":" + sec.trim().substring(0, 2);
		}
	}
	
	public static int getMp3TrackLength(File mp3File) {  
	    try {  
	        MP3File f = (MP3File)AudioFileIO.read(mp3File);  
	        MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();  
	        return audioHeader.getTrackLength();      
	    } catch(Exception e) {  
	        return -1;  
	    }  
	}  
}
