(def +version+ "0.3.1")

(set-env!
  :resource-paths #{"src"}
  :dependencies   '[[org.clojure/clojure "1.8.0" :scope "provided"]
                    [eftest "0.3.1" :scope "test"]
                    [org.clojure/tools.namespace "0.3.0-alpha3" :scope "test"]])

(task-options!
  pom {:project     'metosin/boot-alt-test
       :version     +version+
       :description "Fast Clojure.test runner for Boot"
       :url         "https://github.com/metosin/boot-alt-test"
       :scm         {:url "https://github.com/metosin/boot-alt-test"}
       :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build []
  (comp
    (pom)
    (jar)
    (install)))

(deftask dev []
  (comp
   (watch)
   (repl :server true)
   (build)
   (target)))

(deftask deploy []
  (comp
   (build)
   (push :repo "clojars" :gpg-sign (not (.endsWith +version+ "-SNAPSHOT")))))
