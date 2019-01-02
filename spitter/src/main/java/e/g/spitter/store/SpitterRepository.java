package e.g.spitter.store;

import e.g.spitter.domain.Spitter;

public interface SpitterRepository {
	void save(Spitter spitter);
	Spitter findByUsername(String username);
}
