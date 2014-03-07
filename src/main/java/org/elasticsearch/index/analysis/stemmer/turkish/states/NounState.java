package org.elasticsearch.index.analysis.stemmer.turkish.states;

import org.elasticsearch.index.analysis.stemmer.turkish.suffixes.NounSuffix;

public enum NounState implements State {
  A(true, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch (suffix) {
        case S8: case S11: case S13:
          return B;
        case S9: case S16:
          return C;
        case S18:
          return D;
        case S10: case S17:
          return E;
        case S12: case S14:
          return F;
        case S15:
          return G;
        case S2: case S3: case S4: case S5: case S6:
          return H;
        case S7:
          return K;
        case S1:
          return L;
        case S19:
          return M;
        default:
          return null;
      }
    }
  },

  B(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S2: case S3: case S4: case S5:
          return H;
        case S1:
          return L;
        default:
          return null;
      }
    }
  },

  C(false, false) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S6:
          return H;
        case S7:
          return K;
        default:
          return null;
      }
    }
  },

  D(false, false) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S13:
          return B;
        case S10:
          return E;
        default:
          return null;
      }
    }
  },

  E(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S18:
          return D;
        case S2: case S3: case S4: case S5: case S6:
          return H;
        case S7:
          return K;
        case S1:
          return L;
        default:
          return null;
      }
    }
  },

  F(false, false) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S18:
          return D;
        case S6:
          return H;
        case S7:
          return K;
        default:
          return null;
      }
    }
  },

  G(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S18:
          return D;
        case S2: case S3: case S4: case S5:
          return H;
        case S1:
          return L;
        default:
          return null;
      }
    }
  },

  H(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S1:
          return L;
        default:
          return null;
      }
    }
  },

  K(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) { return null; }
  },

  L(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S18:
          return D;
        default:
          return null;
      }
    }
  },

  M(false, true) {
    @Override
    public State nextState(final NounSuffix suffix) {
      switch(suffix) {
        case S2: case S3: case S4: case S5: case S6:
          return H;
        case S7:
          return K;
        case S1:
          return L;
        default:
          return null;
      }
    }
  };

  private boolean initialState;
  private boolean finalState;

  private NounState(final boolean initialState, final boolean finalState) {
    this.initialState = initialState;
    this.finalState = finalState;
  }

  public boolean initialState() {
    return this.initialState;
  }

  public boolean finalState() {
    return this.finalState;
  }

  public abstract State nextState(NounSuffix suffix);

}
