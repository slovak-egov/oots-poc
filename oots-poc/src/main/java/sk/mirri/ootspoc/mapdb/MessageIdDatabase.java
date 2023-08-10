package sk.mirri.ootspoc.mapdb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.mapdb.Atomic;
import org.mapdb.Atomic.Var;
import org.mapdb.DB;
import org.mapdb.DBMaker;

public class MessageIdDatabase {

	private final DB db;
	private Atomic.Var<List<String>> messagesList;

	// TODO spravit efektivnejsiu databazu
	public MessageIdDatabase(final String aPath) {
		db = DBMaker.fileDB(aPath).checksumHeaderBypass().make();
	}

	@PostConstruct
	public void initialize() {
		messagesList = (Var<List<String>>) db.atomicVar("messagesList", org.mapdb.Serializer.JAVA).createOrOpen();

		if (messagesList.get() == null) {
			messagesList.set(new ArrayList<>());
		}
	}

	public void addMessagesToSkip(List<String> someMessages) {
		someMessages.addAll(messagesList.get());
		messagesList.set(someMessages);
	}

	public List<String> getMessagesToSkip() {
		return messagesList.get();
	}

	public boolean shouldBeSkipped(final String aMessageId) {
		return messagesList.get().contains(aMessageId);
	}

	@PreDestroy
	public void closeDatabase() {
		db.close();
	}

	@PreDestroy
	public void handleShutdownHook() {
		closeDatabase();
	}

	public void cleanup(List<String> someExistingMessages) {
		List<String> toRemove = new LinkedList<String>();
		messagesList.get().forEach(item -> {
			if (!someExistingMessages.contains(item)) {
				toRemove.add(item);
			}
		});
		messagesList.get().removeAll(toRemove);
	}
}