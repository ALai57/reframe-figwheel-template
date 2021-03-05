(ns leiningen.new.reframe-figwheel
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "reframe-figwheel"))

(defn reframe-figwheel
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' reframe-figwheel project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["dev.cljs.edn" (render "dev.cljs.edn" data)]
             ["test.cljs.edn" (render "test.cljs.edn" data)]
             ["figwheel-main.edn" (render "figwheel-main.edn" data)]
             ["README.md" (render "README.md" data)]

             ;; Source
             ["src/{{sanitized}}/core.cljs" (render "src/reframe_figwheel/core.cljs" data)]
             ["src/{{sanitized}}/db.cljs" (render "src/reframe_figwheel/db.cljs" data)]
             ["src/{{sanitized}}/navbar.cljs" (render "src/reframe_figwheel/navbar.cljs" data)]
             ["src/{{sanitized}}/subs.cljs" (render "src/reframe_figwheel/subs.cljs" data)]
             ["src/{{sanitized}}/views.cljs" (render "src/reframe_figwheel/views.cljs" data)]
             ["src/{{sanitized}}/events/core.cljs" (render "src/reframe_figwheel/events/core.cljs" data)]
             ["src/{{sanitized}}/pages/admin.cljs" (render "src/reframe_figwheel/pages/admin.cljs" data)]
             ["src/{{sanitized}}/pages/home.cljs" (render "src/reframe_figwheel/pages/home.cljs" data)]

             ;; Tests
             ["test/{{sanitized}}/core_test.cljs" (render "test/reframe_figwheel/core_test.cljs" data)]
             ["test/{{sanitized}}/test_runner.cljs" (render "test/reframe_figwheel/test_runner.cljs" data)]

             ;; Web pages
             ["resources/public/index.html" (render "resources/public/index.html" data)]
             ["resources/public/test.html" (render "resources/public/test.html" data)]

             ;; CSS
             ["resources/public/css/article-header.css" (render "resources/public/css/article-header.css" data)]
             ["resources/public/css/navbar.css" (render "resources/public/css/navbar.css" data)]
             ["resources/public/css/page.css" (render "resources/public/css/page.css" data)]

             ;; Images
             ["resources/public/images/clojure-logo.svg" (render "resources/public/images/clojure-logo.svg" data)]
             ["resources/public/images/home.svg" (render "resources/public/images/home.svg" data)]
             ["resources/public/images/lock.svg" (render "resources/public/images/lock.svg" data)]

             ["resources/public/images/nav-bar/favicon-white.svg" (render "resources/public/images/nav-bar/favicon-white.svg" data)]
             ["resources/public/images/nav-bar/favicon.svg" (render "resources/public/images/nav-bar/favicon.svg" data)]
             ["resources/public/images/nav-bar/unknown-user.svg" (render "resources/public/images/nav-bar/unknown-user.svg" data)]
             )))
