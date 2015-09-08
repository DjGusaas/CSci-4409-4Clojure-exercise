;Dalton Gusaas, 09/08/2015


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #10: Intro to Maps

; What I pasted in the box:

20

; value of the key

(= 20 (:b {:a 10, :b 20, :c 30}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #16: Hello World

; What I pasted in the box:

format "Hello, %s!"

; based it off of an example in the format docs, the %s seems to be some sort of escape 
; character that also grabs args

(= (format "Hello, %s!" "Dave") "Hello, Dave!")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #17: Sequences: map

; What I pasted in the box:

'(6 7 8)

; map applies #(+ % 5) to each element in the coll

(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #18: Sequences: filter

; What I pasted in the box:

'(6 7)

; filter creates a new coll based off the elements that meet the criteria of #(> % 5)

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #20: Penultimate Element

; What I pasted in the box:

#(nth % (dec (- (count %) 1)))

; passes the position of the desired element to nth, based on the count of the coll

(= (#(nth % (dec (- (count %) 1))) (list 1 2 3 4 5)) 4)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #21: Nth Element

; What I pasted in the box:

#(last (take (+ %2 1) %1))

; grabs every element up to the desired element, then grabs it with last

(= (#(last (take (+ %2 1) %1)) '(4 5 6 7) 2) 6)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #23: Reverse a Sequence

; What I pasted in the box:

into '()

; since it uses conj the elements are put back in reverse order

(= (into '() [1 2 3 4 5]) [5 4 3 2 1])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #25: Find the odd numbers

; What I pasted in the box:

filter odd?

; filter applies odd to the collection, returning the odd elements

(= (filter odd? [2 2 4 6]) '())

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #37: Regular Expressions

; What I pasted in the box:

"ABC"

; [A-Z]+ wants one or more uppercase alphabetical letters and nothing else

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #40: Interpose a Seq

; What I pasted in the box:

#(drop-last (mapcat vector %2 (repeat %1)))

; creates a coll of the arg to be interposed then mapcat takes that and the coll passed in 
; to the function, since there is an extra element drop-last is needed.

(= (#(drop-last (mapcat vector %2 (repeat %1))) 0 [1 2 3]) [1 0 2 0 3])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #43: Reverse Interleave

; What I pasted in the box:

#(apply map list (partition %2 %1))

; partition splits up the coll into n sized pieces, then apply uses map on the result and 
; puts stuff into list

(= (#(apply map list (partition %2 %1)) [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #44: Rotate Sequence

; What I pasted in the box:

#(let [x (count %2)] (take x (drop (mod %1 x) (cycle %2))))

; sets x to count of coll, then cycle creates an infinite seq of the coll which (mod %1 x)
; are dropped off the front, finally x are taken from the front of the infinite seq

(= (#(let [x (count %2)] (take x (drop (mod %1 x) (cycle %2)))) 2 [1 2 3 4 5]) '(3 4 5 1 2))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #46: Flipping out

; What I pasted in the box:

(fn [f] (fn [a b] (f b a)))

; higher order fn takes a fn then passes that function into a function that applies args in 
; the reverse order

(= 3 (((fn [f] (fn [a b] (f b a))) nth) 2 [1 2 3 4 5]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #47: Contain yourself

; What I pasted in the box:

4

; Not sure why it works for vectors, but it makes sense for maps since they have keys

(not (contains? [1 2 4] 4))
(contains? [1 1 1 1 1] 4)

