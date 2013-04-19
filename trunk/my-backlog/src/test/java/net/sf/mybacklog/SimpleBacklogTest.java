package net.sf.mybacklog;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SimpleBacklogTest extends AbstractBacklogging {

	private MyBacklogDisplay display;

	@Before
	public void before() {
		this.display = new MyBacklogDisplay(new SysoutBacklogDisplay());
	}

	@Test
	public void simpleBacklog() {
		final Backlog newBacklog = newBacklog();

		newBacklog.title("simple backlog")

		.done().title("done:").tasks(done("first task", MyTag.first))

		.inProgress().title("in progress:")
				.tasks(inProgress("second task", MyTag.second))

				.waiting().title("waiting:")
				.tasks(waiting("third task", MyTag.third))

				.show();

		assertEquals(
				"simple backlog\n\n  done:\n\n  +++ first task +++ #first\n\n  in progress:\n\n      second task     #second\n\n  waiting:\n\n  --- third task --- #third\n\n",
				this.display.result());
	}

	enum MyTag implements Tag {
		first, second, third
	}

	@Override
	protected Backlog newBacklog() {
		return DefaultBacklogFactory.displayedBy(display()).newBacklog();
	}

	MyBacklogDisplay display() {
		return this.display;
	}

	private static class MyBacklogDisplay implements BacklogDisplay {

		private final BacklogDisplay display;
		private String result;

		public MyBacklogDisplay(final BacklogDisplay display) {
			this.display = display;
		}

		@Override
		public void display(final BacklogAppender appender) {
			this.result = appender.build();
			this.display.display(appender);
		}

		public String result() {
			return this.result;
		}
	}

	static void appendTask(final Appender appender, final Task task) {
		appender.tab().append(task.title()).append("|")
				.append(task.tag().name()).newLine();
	}

}
