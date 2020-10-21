(ns funcional-progam-jconfpe-2020.demo)

(def people
	[{:id 11 :name "Alex" :genre :male :country :peru :is-alive true}
	 {:id 55 :name "Ernesto" :genre :male :country :peru :is-alive false}
	 {:id 22 :name "Carlos" :genre :male :country :mexico :is-alive true}
	 {:id 66 :name "Cesar" :genre :male :country :mexico :is-alive false}
	 {:id 33 :name "Olivia" :genre :female :country :peru :is-alive true}
	 {:id 77 :name "Doris" :genre :female :country :peru :is-alive false}
	 {:id 44 :name "Cecilia" :genre :female :country :mexico :is-alive true}
	 {:id 88 :name "Veronica" :genre :female :country :mexico :is-alive false}
	 {:id 99 :name "Angela" :genre :female :country :peru :is-alive true}
	 {:id 10 :name "Gabriel" :genre :male :country :peru :is-alive true}])

(defn belongs?
	[op keyword value coll]
	(filter #(op (keyword %) value) coll))

(defn convert
	[item]
	#:person{:identifier (:id item)
					 :first-name (:name item)
					 :country    (:country item)
					 :alive      (:is-alive item)
					 :genre      (:genre item)})

(map convert (filter #(belongs? not= :country :mexico %) (filter #(belongs? = :genre :male %) people)))

(->> people
	(belongs? = :genre :male)
	(belongs? not= :country :mexico)
	(belongs? = :is-alive true)
	(map convert))

(defn group-people
	[coll]
	(reduce
		(fn [acc person]
			(condp = [(:person/country person) (:person/alive person)]
				[:mexico true] (update-in acc [:mexico :alive] conj person)
				[:mexico false] (update-in acc [:mexico :not-alive] conj person)
				[:peru true] (update-in acc [:peru :alive] conj person)
				[:peru false] (update-in acc [:peru :not-alive] conj person)))
		{}
		coll))

(->> people
	(map convert)
	(group-people))
