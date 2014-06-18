// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package eu.musesproject.server.rt2ae;

import eu.musesproject.server.rt2ae.Clue;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Clue_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Clue.entityManager;
    
    public static final EntityManager Clue.entityManager() {
        EntityManager em = new Clue().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Clue.countClues() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Clue o", Long.class).getSingleResult();
    }
    
    public static List<Clue> Clue.findAllClues() {
        return entityManager().createQuery("SELECT o FROM Clue o", Clue.class).getResultList();
    }
    
    public static Clue Clue.findClue(Integer clueId) {
        if (clueId == null) return null;
        return entityManager().find(Clue.class, clueId);
    }
    
    public static List<Clue> Clue.findClueEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Clue o", Clue.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Clue.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Clue.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Clue attached = Clue.findClue(this.clueId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Clue.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Clue.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Clue Clue.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Clue merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
