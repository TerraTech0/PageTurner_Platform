package com.example.pageturnerns.Repository;

import com.example.pageturnerns.Model.Event;
import com.example.pageturnerns.Model.JoinSession;
import com.example.pageturnerns.Model.Meeting;
import com.example.pageturnerns.Model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinSessionRepository extends JpaRepository<JoinSession, Integer> {
    JoinSession findByEventsAndReaders(Event event, Reader reader);

    @Query("select meeting from Reader meeting where meeting.meeting.meetingId=?1 and meeting.readerId=?2")
    JoinSession findByMeetingIdAndReaderId(Integer meetingId, Integer readerId);


}
