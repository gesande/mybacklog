package net.sf.mybacklog;

public class MyBacklog extends AbstractBacklogging {

	public static void main(final String[] args) {
		new MyBacklog().show();
	}

	public void show() {
		newBacklog()
				.title("my-backlog backlog")

				.done()
				.title("DONE")
				.tasks(done("first release, quick and dirty :)", feature()),
						done("introduced chalked-backlog", refactoring()),
						done("improve test coverage for my-backlog module",
								quality()),
						done("introduced DefaultBacklogFactory", feature()),
						done("making DefaultBacklogFactory accessible to public",
								feature()),
						done("started work for version 1.0.3", newVersion()),
						done("provide tag through AbstractBacklogging",
								feature()))

				.inProgress().title("IN PROGRESS").noTasks().

				waiting().title("WAITING")
				.tasks(waiting("start work for version 1.0.4", newVersion()))
				.show();
	}

	@Override
	protected Backlog newBacklog() {
		return DefaultBacklogFactory.displayedBy(new SysoutBacklogDisplay())
				.newBacklog();
	}

	private Tag newVersion() {
		return tag("new-version");
	}

	private Tag feature() {
		return tag("feature");
	}

	private Tag refactoring() {
		return tag("refactoring");
	}

	private Tag quality() {
		return tag("quality");
	}
}
