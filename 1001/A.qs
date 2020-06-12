namespace Solution {
    open Microsoft.Quantum.Intrinsic;

    operation Solve (q : Qubit, sign : Int) : Unit {
        if (sign == -1) {
            X(q);
        }

        H(q);
    }
}
