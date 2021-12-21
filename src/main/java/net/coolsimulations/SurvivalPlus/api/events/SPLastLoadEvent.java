package net.coolsimulations.SurvivalPlus.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface SPLastLoadEvent {
	Event<SPLastLoadEvent> EVENT = EventFactory.createArrayBacked(SPLastLoadEvent.class, (listeners) -> () -> {
		for (SPLastLoadEvent listener : listeners) {
			listener.load();
		}
	});

	void load();
}
