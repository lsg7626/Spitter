package e.g.spitter.store;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import e.g.spitter.domain.Spitter;

@Repository
public class SpitterRepositoryLogic implements SpitterRepository{
	
	InputStream in = null;
	BufferedInputStream bin = null;
	ObjectInputStream oin = null;
	
	@Override
	public void save(Spitter spitter) {
		List<Spitter> spitters = getSpitters();
		spitters.add(spitter);
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		try {
			out = new FileOutputStream("c:/spittle/spitters.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
	        oout.writeObject(spitters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Spitter findByUsername(String username) {
		List<Spitter> spitters = getSpitters();
		
		int index = 0;
		for(Spitter s: spitters) {
			if(s.getUsername().equals(username))
				break;
			else
				index++;
		}
		if(spitters.size() != 0 && spitters.get(0) != null) {
			System.out.println("spitters 정상");
		}
		else {
			System.out.println("비정상");
		}
		return spitters.get(index);
	}
	
	private List<Spitter> getSpitters() {
		List<Spitter> spitters = null;
		try {
			in = new FileInputStream("c:/spittle/spitters.txt");
			System.out.println("FileinputStream 통과");
			bin = new BufferedInputStream(in);
			System.out.println("bufferedinputstream 통과");
			oin = new ObjectInputStream(bin);
			System.out.println("objectinputstream 통과");
			spitters = (ArrayList<Spitter>)oin.readObject();
			if(spitters != null)
				System.out.println("size : " + spitters.size());
			else
				System.out.println("spitters equals Null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(spitters == null) {
			spitters = new ArrayList();
		}
		return spitters;
	}
}
