package net.sf.mybacklog.chalked;

import net.sf.chalkbox.Chalk;
import net.sf.mybacklog.Appendable;
import net.sf.mybacklog.AppenderAs;
import net.sf.mybacklog.Waiting;

final class ChalkedWaiting implements Appendable<Waiting> {

    private final Chalk chalk;
    private final AppenderAs<Waiting> appendable;

    public ChalkedWaiting(final Chalk chalk,
            final AppenderAs<Waiting> appendable) {
        this.chalk = chalk;
        this.appendable = appendable;
    }

    @Override
    public String build(final Waiting task) {
        return chalk().write(appenderAs().task(task).build());
    }

    private AppenderAs<Waiting> appenderAs() {
        return this.appendable;
    }

    private Chalk chalk() {
        return this.chalk;
    }
}