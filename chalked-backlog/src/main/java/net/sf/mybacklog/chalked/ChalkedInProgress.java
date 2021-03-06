package net.sf.mybacklog.chalked;

import net.sf.chalkbox.Chalk;
import net.sf.mybacklog.Appendable;
import net.sf.mybacklog.AppenderAs;
import net.sf.mybacklog.InProgress;

final class ChalkedInProgress implements Appendable<InProgress> {
    private final Chalk chalk;
    private final AppenderAs<InProgress> appenderAs;

    public ChalkedInProgress(final Chalk chalk,
            final AppenderAs<InProgress> appendable) {
        this.chalk = chalk;
        this.appenderAs = appendable;
    }

    @Override
    public String build(final InProgress task) {
        return chalk().write(appenderAs().task(task).build());
    }

    private AppenderAs<InProgress> appenderAs() {
        return this.appenderAs;
    }

    private Chalk chalk() {
        return this.chalk;
    }
}