package seedu.address.commons.util;

import seedu.address.logic.commands.eventcommands.EditEventCommand;
import seedu.address.model.tag.Tag;
import seedu.address.model.types.common.Address;
import seedu.address.model.types.common.DateTime;
import seedu.address.model.types.common.Name;

import java.util.*;

/**
 * Stores the details to edit the event with. Each non-empty field value will replace the
 * corresponding field value of the event.
 */
public class EditEventDescriptor {
    private Name name;
    private Address address;
    private DateTime startTime;
    private Set<Tag> tags;

    public EditEventDescriptor() {}

    /**
     * Copy constructor.
     * A defensive copy of {@code tags} is used internally.
     */
    public EditEventDescriptor(EditEventDescriptor toCopy) {
        setName(toCopy.name);
        setAddress(toCopy.address);
        setStartTime(toCopy.startTime);
        setTags(toCopy.tags);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(name, address, startTime, tags);
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Optional<Name> getName() {
        return Optional.ofNullable(name);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public Optional<DateTime> getStartTime() {
        return Optional.ofNullable(startTime);
    }

    /**
     * Sets {@code tags} to this object's {@code tags}.
     * A defensive copy of {@code tags} is used internally.
     */
    public void setTags(Set<Tag> tags) {
        this.tags = (tags != null) ? new HashSet<>(tags) : null;
    }

    /**
     * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     * Returns {@code Optional#empty()} if {@code tags} is null.
     */
    public Optional<Set<Tag>> getTags() {
        return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditEventDescriptor)) {
            return false;
        }

        EditEventDescriptor otherEditEventDescriptor =
                (EditEventDescriptor) other;
        return Objects.equals(name, otherEditEventDescriptor.name)
                && Objects.equals(address, otherEditEventDescriptor.address)
                && Objects.equals(startTime, otherEditEventDescriptor.startTime)
                && Objects.equals(tags, otherEditEventDescriptor.tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("address", address)
                .add("start time", startTime)
                .add("tags", tags)
                .toString();
    }
}
