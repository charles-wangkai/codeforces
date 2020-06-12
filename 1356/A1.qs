namespace Solution {
    open Microsoft.Quantum.Intrinsic;

    operation Solve (unitary : (Qubit => Unit is Adj+Ctl)) : Int {
        mutable result = -1;

        using (q = Qubit()) {
            unitary(q);

            if (M(q) == Zero) {
                set result = 0;
            } else {
                set result = 1;
            }

            Reset(q);
        }

        return result;
    }
}