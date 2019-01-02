package e.g.spitter.store;

import java.util.List;

import e.g.spitter.domain.Spittle;

public interface SpittleRepository {
	List<Spittle> recentSpittles();
	List<Spittle> findSpittles(int index);
	Spittle findOne(long spittleId);
	void save(Spittle spittle);
}
