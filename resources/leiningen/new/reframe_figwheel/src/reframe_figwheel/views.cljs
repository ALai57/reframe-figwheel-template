(ns {{name}}.views
  (:require [{{name}}.navbar :as nav]
            [{{name}}.pages.home :refer [home]]
            [{{name}}.pages.admin :refer [login-ui]]
            [re-frame.core :refer [subscribe]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Landing pages
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Panels
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def panels {:home [home]
             :admin [login-ui]})

(defn app []
  (let [active-panel (subscribe [:active-panel])]
    (fn []
      (println "active panel" active-panel)
      (get panels @active-panel))))

