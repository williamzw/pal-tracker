package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> list;
    private long internalID = 1;
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(internalID++);
        list.add(timeEntry);
        return timeEntry;
    }

    public TimeEntry find(Long id) {
         for(TimeEntry t : list){
             if(t.getId() == (long)id)
                 return t;
         }
         return null;
    }


    public List<TimeEntry> list() {
        return list;
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        for(TimeEntry t : list){
            if(t.getId()== (long)id){
                t.setDate(timeEntry.getDate());
                t.setHours(timeEntry.getHours());
                t.setProjectId(timeEntry.getProjectId());
                t.setUserId(timeEntry.getUserId());
                return t;
            }
        }
        return null;
    }

    public void delete(Long id) {
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getId()== (long) id){
                list.remove(i);
            }
        }
    }

    public InMemoryTimeEntryRepository() {
        this.list = new ArrayList<TimeEntry>();
        this.internalID = 1;
    }
}

