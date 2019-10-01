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

    public TimeEntry find(long id) {
         for(TimeEntry t : list){
             if(t.getId() == id)
                 return t;
         }
         return null;
    }


    public List<TimeEntry> list() {
        return list;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        for(TimeEntry t : list){
            if(t.getId()==id){
                t.setDate(timeEntry.getDate());
                t.setHours(timeEntry.getHours());
                t.setProjectId(timeEntry.getProjectId());
                t.setUserId(timeEntry.getUserId());
                return t;
            }
        }
        return null;
    }

    public void delete(long id) {
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getId()==id){
                list.remove(i);
            }
        }
    }

    public InMemoryTimeEntryRepository() {
        this.list = new ArrayList<TimeEntry>();
        this.internalID = 1;
    }
}

