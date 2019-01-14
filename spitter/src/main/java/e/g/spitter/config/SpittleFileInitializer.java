package e.g.spitter.config;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import e.g.spitter.domain.Spittle;

public class SpittleFileInitializer {

	public static void main(String[] args)  throws IOException{		
		OutputStream out = new FileOutputStream("c:/spittle/spittles.txt");
		BufferedOutputStream bout = new BufferedOutputStream(out);
		ObjectOutputStream oout = new ObjectOutputStream(bout);
		ArrayList<Spittle> spittles = new ArrayList<>();
        for(int i=1; i<=5000; i++) {
        	spittles.add(new Spittle((long) i, "Spittle " + i, new Date(), 22.2, 11.1)); 
        }
        oout.writeObject(spittles);
        oout.close();
        
        System.out.println("파일 초기화 성공");
	}
}
