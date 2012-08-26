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

   public String getType() {
      return type;
   }

   public boolean isType(Object obj) {
      return false;
   }

   // public Object getByType(Class type) {
   // if( instanceof type){

   // }
   // return type;

   // }

   public abstract void update(double delta, Action action);

   // TODO make recive events for msg passing.

}
