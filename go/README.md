# Go

Exercises in Go can be run with:

    go test -v

And with benchmarking:

    go test -bench=./ -v

Benchmarking without the tests:

    go test -bench=. -count 5 -run=^#
