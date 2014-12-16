(ns sample-reagent.core
   (:require [reagent.core :as reagent :refer [atom]]))

(defn home []                                                                                    
  [:div                                                                                        
     [:div.page-header [:h1 "THIS IS A HEADER!!!!"]]]) 

(defn start []
  (.log js/console (pr-str [1 2 3 4]))
  (reagent/render [home] (.getElementById js/document "app")))
