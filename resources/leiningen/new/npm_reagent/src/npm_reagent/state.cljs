(ns {{name}}.state
  (:require [reagent.core :as r]))

(def {{name}}s (r/atom {:{{name}}-12 {:id :{{name}}-12
                            :title "Title of Blog Post"
                            :post "Contents of blog post."
                            :img "https://www.image.com/foo.jpg"}}))
