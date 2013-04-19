package net.sf.mybacklog;

class DefaultBacklogFactory implements BacklogFactory {
	private final BacklogDisplay display;

	private DefaultBacklogFactory(final BacklogDisplay display) {
		this.display = display;
	}

	private BacklogDisplay display() {
		return this.display;
	}

	public static BacklogFactory displayedBy(final BacklogDisplay display) {
		return new DefaultBacklogFactory(display);
	}

	@Override
	public Backlog newBacklog() {
		final Appender appender = new StringBuilderAppender();
		final AppenderAs<Done> appenderAsDone = new DoneAsAppender();
		final Appendable<Done> doneAppendable = new Appendable<Done>() {
			@Override
			public String build(final Done task) {
				return appenderAsDone.task(task).build();
			}
		};
		final DoneAppender doneAppender = new DoneAppender(appender,
				doneAppendable);
		final AppenderAs<InProgress> appenderAsInProgress = new InProgressAsAppender();
		final Appendable<InProgress> inProgressAppendable = new Appendable<InProgress>() {
			@Override
			public String build(final InProgress task) {
				return appenderAsInProgress.task(task).build();
			}
		};
		final InProgressAppender inProgressAppender = new InProgressAppender(
				appender, inProgressAppendable);
		final AppenderAs<Waiting> appenderAsWaiting = new WaitingAsAppender();
		final Appendable<Waiting> waitingAppendable = new Appendable<Waiting>() {
			@Override
			public String build(final Waiting task) {
				return appenderAsWaiting.task(task).build();
			}
		};
		final WaitingAppender waitingAppender = new WaitingAppender(appender,
				waitingAppendable);

		final DefaultBacklogAppender backlogAppender = new DefaultBacklogAppender(
				appender, doneAppender, inProgressAppender, waitingAppender);
		final TaskListFactory taskListFactory = new DefaultTaskListFactory(
				backlogAppender);
		return new BacklogImpl(backlogAppender, display(), taskListFactory);
	}

}