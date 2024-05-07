package com.example.pageturnerns.Repository;

import com.example.pageturnerns.Model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer> {
    Writer findWriterByWriterId(Integer writerId);

}
