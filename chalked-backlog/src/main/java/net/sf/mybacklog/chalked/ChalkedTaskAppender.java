package net.sf.mybacklog.chalked;

import net.sf.chalkbox.Chalk;
import net.sf.mybacklog.Appender;
import net.sf.mybacklog.Done;
import net.sf.mybacklog.DoneAppender;
import net.sf.mybacklog.DoneAsAppender;
import net.sf.mybacklog.InProgress;
import net.sf.mybacklog.InProgressAppender;
import net.sf.mybacklog.InProgressAsAppender;
import net.sf.mybacklog.TaskAppender;
import net.sf.mybacklog.Waiting;
import net.sf.mybacklog.WaitingAppender;
import net.sf.mybacklog.WaitingAsAppender;

@SuppressWarnings("static-method")
public final class ChalkedTaskAppender {

    public TaskAppender<Waiting> forWaiting(final Appender appender,
            final Chalk chalk) {
        return new WaitingAppender(appender, new ChalkedWaiting(chalk,
                new WaitingAsAppender()));
    }

    public TaskAppender<Done> forDone(final Appender appender, final Chalk chalk) {
        return new DoneAppender(appender, new ChalkedDone(chalk,
                new DoneAsAppender()));
    }

    public TaskAppender<InProgress> forInProgress(final Appender appender,
            final Chalk chalk) {
        return new InProgressAppender(appender, new ChalkedInProgress(chalk,
                new InProgressAsAppender()));
    }
}
