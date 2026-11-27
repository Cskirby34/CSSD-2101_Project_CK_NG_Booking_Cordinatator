import java.time.LocalDateTime;
import java.util.Objects;

public final class TimeSlot {

    private final LocalDateTime start;
    private final LocalDateTime end;

    public TimeSlot(LocalDateTime start, LocalDateTime end) {
        this.start = Objects.requireNonNull(
                start, "Start time cannot be null");
        this.end = Objects.requireNonNull(
                end, "End time cannot be null");
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException(
                    "End time must be after start time");
        }
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public boolean overlaps(TimeSlot other) {

        Objects.requireNonNull(other, "TimeSlot cannot be null");

        return start.isBefore(other.end)
                && other.start.isBefore(end);
    }

    @Override
    public String toString() {
        return start + " to " + end;
    }
}

