package net.sf.mybacklog;

public class MyBacklog extends AbstractBacklogging {

	public void show() {
		newBacklog()
				.title("my-backlog backlog")
				.done()
				.title("DONE")
				.tasks(done("first release, quick and dirty :)", feature()),

						done("introduced chalked-backlog",
								MyBacklogTag.refactoring),

						done("improve test coverage for my-backlog module",
								MyBacklogTag.quality),

						done("introduced DefaultBacklogFactory", feature())

				)

				.inProgress().title("IN PROGRESS").noTasks().waiting()
				.title("WAITING").noTasks().show();
	}

	@Override
	protected Backlog newBacklog() {
		return DefaultBacklogFactory.displayedBy(new SysoutBacklogDisplay())
				.newBacklog();
	}

	private static MyBacklogTag feature() {
		return MyBacklogTag.feature;
	}

	enum MyBacklogTag implements Tag {
		refactoring, quality, feature
	}
}
