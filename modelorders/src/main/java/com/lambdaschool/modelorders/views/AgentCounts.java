package com.lambdaschool.modelorders.views;

/**
 * Used to format the JSON output for a custom query that gathers information on restaurants
 * and the count of their menu items
 */
public interface AgentCounts{
   /**
    * The name of the restaurant. Must be called name
    *
    * @return the name (String) of restaurant
    */
   String getAgentname();

   /**
    * The count of the count of the menu items. Must be called countmenus
    *
    * @return the count (int) of the menu items
    */
   int getCountagent();
}
