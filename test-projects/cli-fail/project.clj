(def bat-test-version
  (:out ((requiring-resolve 'clojure.java.shell/sh)
         "clojure" "-T:build" "install"
         :dir "../..")))
(defproject metosin-test/cli-fail "1.0.0-SNAPSHOT"
  :test-paths ["test-pass"
               "test-fail"]
  :dependencies [[org.clojure/clojure "1.10.3"]]
  :plugins [[metosin/bat-test ~bat-test-version]])
