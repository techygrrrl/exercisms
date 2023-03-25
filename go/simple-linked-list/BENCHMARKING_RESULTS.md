Command:

    go test -bench=. -count 5 -run=^#

Result:

```text
goos: darwin
goarch: amd64
pkg: linkedlist
cpu: Intel(R) Core(TM) i9-9880H CPU @ 2.30GHz
BenchmarkNewList-16        	 3522856	       329.4 ns/op
BenchmarkNewList-16        	 3601712	       329.3 ns/op
BenchmarkNewList-16        	 3596464	       333.6 ns/op
BenchmarkNewList-16        	 3350499	       328.6 ns/op
BenchmarkNewList-16        	 3449607	       329.6 ns/op
BenchmarkListSize-16       	1000000000	         0.2607 ns/op
BenchmarkListSize-16       	1000000000	         0.2564 ns/op
BenchmarkListSize-16       	1000000000	         0.2734 ns/op
BenchmarkListSize-16       	1000000000	         0.2586 ns/op
BenchmarkListSize-16       	1000000000	         0.2597 ns/op
BenchmarkListPush-16       	   31971	     37070 ns/op
BenchmarkListPush-16       	   32136	     37058 ns/op
BenchmarkListPush-16       	   32643	     37343 ns/op
BenchmarkListPush-16       	   31857	     37612 ns/op
BenchmarkListPush-16       	   32433	     38056 ns/op
BenchmarkListPop-16        	  407650	      3015 ns/op
BenchmarkListPop-16        	  409896	      2968 ns/op
BenchmarkListPop-16        	  404592	      2949 ns/op
BenchmarkListPop-16        	  400926	      2964 ns/op
BenchmarkListPop-16        	  399824	      2973 ns/op
BenchmarkListToArray-16    	1000000000	         0.5133 ns/op
BenchmarkListToArray-16    	1000000000	         0.5155 ns/op
BenchmarkListToArray-16    	1000000000	         0.5236 ns/op
BenchmarkListToArray-16    	1000000000	         0.5312 ns/op
BenchmarkListToArray-16    	1000000000	         0.5214 ns/op
BenchmarkListReverse-16    	 2939199	       410.4 ns/op
BenchmarkListReverse-16    	 2942032	       403.3 ns/op
BenchmarkListReverse-16    	 2954568	       407.9 ns/op
BenchmarkListReverse-16    	 2962248	       405.5 ns/op
BenchmarkListReverse-16    	 2967759	       403.1 ns/op
PASS
ok  	linkedlist	235.667s
```