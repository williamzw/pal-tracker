package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(timeEntryToCreate,HttpStatus.CREATED);
    }
    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry res = timeEntryRepository.find(id);
        return new ResponseEntity(res,res == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry expected) {
        TimeEntry res = timeEntryRepository.update(id,expected);
        return new ResponseEntity(res,res == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);

    }
    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable long id ) {
        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(),HttpStatus.OK);
    }
}
