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

   public void addComponent(Component component) {
      components.add(component);
   }

   public void getComponent(int index) {
      components.get(index);
   }

   public void removeComponent(int index) {
      components.remove(index);
      // TODO add checking for remove
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
   public abstract void render(Graphics2D g);

   // TODO implement message passing and event interface

   // Taken care of by renderable component
   // public abstract void render();

}
