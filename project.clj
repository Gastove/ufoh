(defproject ufoh "0.1.0-SNAPSHOT"
  :description "This is me, noodling about with an infochimps UFO dataset in Clojure. "
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[incanter "1.5.4"]
                 [org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot ufoh.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
