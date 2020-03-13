package by.it.academy.scientific_activity.repository;

import by.it.academy.scientific_activity.entity.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
