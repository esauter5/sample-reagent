(ns sample-reagent.core
   (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)
(def state (atom {:text "Enter text" :value 1}))

(defn row [label & body]
  [:div.row
   [:div.col-md-2 [:span label]]
   [:div.cold-md-3 body]])

(defn text-input [test label]
   [row label [:input {:type "text" 
                       :class "form-control"
                       :value (@test :text)
                       :onChange #(swap! test assoc :text (-> % .-target .-value))}]])

(defn output-text [test]
  [:p (@test :text)])

(defn home []                                                                                    
  [:div                                                                                        
     [:div.page-header [:h1 "THIS IS A HEADER!!!!"]]
     [text-input state "First name"]
     [output-text state]])

(defn start [message]
  (swap! state assoc :text message)
  (.log js/console (pr-str [1 2 3 4]))
  (println "Hey")
  (reagent/render [home] (.getElementById js/document "app")))
