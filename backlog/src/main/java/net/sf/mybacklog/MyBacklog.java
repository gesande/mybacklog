package net.sf.mybacklog;

import static net.sf.mybacklog.MyBacklog.BacklogTag.feature;
import static net.sf.mybacklog.MyBacklog.BacklogTag.quality;
import static net.sf.mybacklog.MyBacklog.BacklogTag.refactoring;

public class MyBacklog extends AbstractBacklogging {

	public static void main(final String[] args) {
		new MyBacklog().show();
	}

	public void show() {
		newBacklog()
				.title("my-backlog backlog")
				.done()
				.title("DONE")
				.tasks(done("first release, quick and dirty :)", feature),
						done("introduced chalked-backlog", refactoring),
						done("improve test coverage for my-backlog module",
								quality),
						done("introduced DefaultBacklogFactory", feature))

				.inProgress().title("IN PROGRESS").noTasks().waiting()
				.title("WAITING").noTasks().show();
	}

	@Override
	protected Backlog newBacklog() {
		return DefaultBacklogFactory.displayedBy(new SysoutBacklogDisplay())
				.newBacklog();
	}

	public enum BacklogTag implements Tag {
		refactoring, quality, feature
	}
}
