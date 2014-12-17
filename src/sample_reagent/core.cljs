(ns sample-reagent.core
   (:require [reagent.core :as reagent :refer [atom]]))

(def state (atom "Enter text"))

(defn row [label & body]
  [:div.row
   [:div.col-md-2 [:span label]]
   [:div.cold-md-3 body]])

(defn text-input [test label]
   [row label [:input {:type "text" 
                       :class "form-control"
                       :value @test
                       :onChange #(reset! test (-> % .-target .-value))}]])

(defn output-text [test]
  [:p @test])

(defn home []                                                                                    
  [:div                                                                                        
     [:div.page-header [:h1 "THIS IS A HEADER!!!!"]]
     [text-input state "First name"]
     [output-text state]])

(defn start []
  (.log js/console (pr-str [1 2 3 4]))
  (reagent/render [home] (.getElementById js/document "app")))
