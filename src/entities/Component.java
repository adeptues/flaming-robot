/**
 * 
 */
package entities;

import core.Action;

/**
 * @author adeptues
 * 
 */
public abstract class Component {

   private String uniqueID;
   private String entityID;
   private String type;
   private String name;
   private Entity entity;

   public Component(Entity entity){
	   this.entity = entity;
   }
   public String getType() {
      return type;
   }

   public boolean isType(Object obj) {
      return false;
   }
   
   /**
    * receives a message from the parent entity
    * @param msg
    */
   public abstract void handleMessage(Message msg);
   
   public void broadcastMessage(Message msg){
	   entity.handleMessage(msg);
   }


   public abstract void update(double delta, Action action);

   // TODO make recive events for msg passing.

}
