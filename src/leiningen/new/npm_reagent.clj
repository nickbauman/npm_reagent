(ns leiningen.new.npm-reagent
  (:require [clojure.java.io :refer [input-stream]]
            [leiningen.new.templates :refer [renderer name-to-path ->files slurp-resource]]
            [leiningen.core.main :as main]))

(def render (renderer "npm-reagent"))

(defn raw-copy
      "Use in case of binary files that just need to be copied verbatim.
      (... the default renderer apparently tries to decode the file :/)"
      [filename, data]
      (input-stream (clojure.string/join "/" ["resources/leiningen/new/npm_reagent" filename])))

(defn npm-reagent
  "Expands template vars over files, as needed"
  [name]
  (let [data {:name name
              :year (+ 1900 (.getYear (new java.util.Date)))
              :sanitized (name-to-path name)}]
    (main/info (str "Generating new npm-reagent project '" name "'"))
    (->files data
             ; public
             ["public/index.html" (render "public/index.html" data)]
             ["public/css/style.css" (render "public/css/style.css" data)]
             ["public/img/{{name}}-icon.png" (raw-copy "public/img/npm-reagent-icon.png" data)]
             ["public/img/{{name}}-logo.svg" (raw-copy "public/img/npm-reagent-logo.svg" data)]

             ; {{name}} package
             ["src/{{sanitized}}/core.cljs" (render "src/npm_reagent/core.cljs" data)]
             ["src/{{sanitized}}/state.cljs" (render "src/npm_reagent/state.cljs" data)]

             ; root of project
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]
             ["package.json" (render "package.json" data)]
             [".gitignore" (render ".gitignore" data)]
             ["README.md" (render "README.md" data)])))
