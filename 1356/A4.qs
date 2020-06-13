namespace Solution {
    open Microsoft.Quantum.Intrinsic;

    operation Solve (unitary : (Qubit[] => Unit is Adj+Ctl)) : Int {
        mutable result = -1;

        using (qs = Qubit[2]) {
            unitary(qs);

            if (M(qs[1]) == One) {
                set result = 0;
            } else {
                set result = 1;
            }

            ResetAll(qs);
        }

        return result;
    }
}