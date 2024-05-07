package com.example.pageturnerns.Repository;

import com.example.pageturnerns.Model.Goals;
import com.example.pageturnerns.Model.Reader;
import com.example.pageturnerns.Model.User;
import lombok.Locked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalsRepository extends JpaRepository<Goals,Integer> {
    Goals findGoalsByTitle(String title);
    Goals findGoalsByGoalsID(Integer genreId);

    List<Goals> findAllByReader(User reader);
}
