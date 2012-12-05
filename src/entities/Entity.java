/**
 * 
 */
package entities;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import core.Action;

/**
 * @author adeptues
 * 
 */
public abstract class Entity {
   /**
    * List of components which this entity has acess to the components define this entities behaviour
    */
   private List<Component> components;
   private String ID;
   private String humanReadableName;

   public Entity(String iD, String humanReadableName) {
      components = new LinkedList<Component>();
      ID = iD;
      this.humanReadableName = humanReadableName;
   }

   public Object getComponentByType(Class<?> type) {
      for (int i = 0; i < components.size(); i++) {
         if (type.isInstance(components.get(i))) {
            // return the component we where looking for
            return components.get(i);
         }
      }
      return null;
   }

   public void attachComponent(Component component) {
      components.add(component);
   }

   public void getComponent(int index) {
      components.get(index);
   }

   public void detachComponent(int index) {
      components.remove(index);
      // TODO add checking for remove
   }
   
   /**
    * <P>
    * part of the component entity messaging system a message should be received by this entity from either the 
    * entity manager or another entity or the world environment or subsystem. The message should then be propagated
    * to all of the entities subcomponents at which point they should decide whether they should respond and if they
    * do the responding component can send a message to its parent entity which will then in turn be propagated back to
    * all of its child components including the component that broadcasted the message but it will be smart enough to ignore
    * the message. A message can have either local or global context ie a message should be propagated only to the 
    * components parent entity and its subcomponents for a local context and global for the message to leave the entity
    * and enter the game world.</P>
    * 
    * <P>A scenario where this could occur might be when a damage message has been received by the entity the entity then
    * propagates the message to its child components the health component is configured to respond to damage events
    * and thus reduces its health by the content of the message but is also programmed to send out a death event if the
    * health reaches 0 which would then have a global context which would be propagated to the local components and 
    * the global environment such that the death animation component can respond and execute its behaviour and the
    * Environment or entity manager can remove it from the game and treat it as destroyed or set it to inactive.</P>
    */
   public void handleMessage(Message msg){
	   
   }

   // TODO define constructor which requires basic components such as renderable, moveable and physics
   // TODO action could be replaced with the game speceific event systems
   public void update(double delta, Action action) {
      // call update on all components
      for (int i = 0; i < components.size(); i++) {
         components.get(i).update(delta, action);
      }

   }

   /**
    * This is responsible for rendering and drawing the entity however in the future this may be replaced for
    * a renderable component
    */
   @Deprecated
   public abstract void render(Graphics2D g);

   public abstract void render();

   // TODO implement message passing and event interface

   // Taken care of by renderable component
   // public abstract void render();

}
