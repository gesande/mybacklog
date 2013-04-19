package net.sf.mybacklog;

public class SimpleBacklogExample extends AbstractBacklogging {

	public static void main(String[] args) {
		new SimpleBacklogExample().show();
	}

	@Override
	protected Backlog newBacklog() {
		return DefaultBacklogFactory.displayedBy(new SysoutBacklogDisplay())
				.newBacklog();
	}

	public void show() {
		newBacklog().title("Backlog example").done().title("DONE")
				.tasks(done("simple backlog example", example())).inProgress()
				.title("IN PROGRESS").noTasks().waiting().title("WAITING")
				.tasks(waiting("more examples", example())).show();
	}

	private static TaskTags example() {
		return TaskTags.example;
	}

	enum TaskTags implements Tag {
		example;
	}
}
